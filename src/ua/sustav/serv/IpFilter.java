package ua.sustav.serv;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ukr-sustavov
 * on 05.02.2018.
 */
public class IpFilter implements Filter {

    private static final String FILE_WITH_IP = "/WEB-INF/resource/ip.txt";
    private FilterConfig filterConfig;
    private Map<String, String> mapOfIP = new ConcurrentHashMap<>();
    long lastModified;

    public IpFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String userIp = servletRequest.getRemoteAddr();
        ServletContext context = servletRequest.getServletContext();
        URL fileName = context.getResource(FILE_WITH_IP);

        Path path = null;

        try {
            path = Paths.get(fileName.toURI());
            File file = path.toFile();
            if (lastModified != file.lastModified()) {
                mapOfIP.clear();
                lastModified = file.lastModified();
                readIpListFromFile(path);
            }
        } catch (URISyntaxException e) {

        }

        HttpServletResponse httpResponse = null;
        if (servletResponse instanceof HttpServletResponse){
            httpResponse = (HttpServletResponse) servletResponse;
        }

        if (mapOfIP.containsKey(userIp)) {
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "You are not allowed to access the servlet!");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    private void readIpListFromFile(Path path) {

        try (Stream<String> stream = Files.lines(path)) {

            mapOfIP = stream
                    .filter(line -> !line.startsWith("#"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toMap(line -> line, line -> line));

        } catch (IOException e) {

        }

    }

    @Override
    public void destroy() {

    }
}
