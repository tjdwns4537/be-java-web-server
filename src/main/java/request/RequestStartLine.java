package request;

import java.util.Map;

public class RequestStartLine {
    private final Method method;
    private final Uri uri;
    private final HttpVersion version;

    public RequestStartLine(Method method, Uri uri, HttpVersion version) {
        this.method = method;
        this.uri = uri;
        this.version = version;
    }

    public static RequestStartLine of(String source) {
        String[] sources = source.split(" ");
        Method method = Method.of(sources[0]);
        Uri uri = Uri.of(sources[1]);
        HttpVersion httpVersion = HttpVersion.of(sources[2]);

        return new RequestStartLine(method, uri, httpVersion);
    }

    public boolean isTemplatesResource() {
        return uri.isTemplatesResource();
    }

    public boolean isStaticResource() {
        return uri.isStaticResource();
    }

    public Method getMethod() {
        return method;
    }

    public String getPath() {
        return uri.getPath();
    }

    public Map<String, String> getParameters() {
        return uri.getParameters();
    }
}
