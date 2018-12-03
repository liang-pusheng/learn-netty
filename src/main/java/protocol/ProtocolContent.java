package protocol;

// 消息主体
public class ProtocolContent {

    private ProtocolHeader protocolHeader;

    private String content;

    public ProtocolContent(ProtocolHeader protocolHeader, String content) {
        this.protocolHeader = protocolHeader;
        this.content = content;
    }

    public ProtocolHeader getProtocolHeader() {
        return protocolHeader;
    }

    public void setProtocolHeader(ProtocolHeader protocolHeader) {
        this.protocolHeader = protocolHeader;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("[version=%d, contentLength=%d, sessionId=%s, content=%s]",
                             protocolHeader.getVersion(), protocolHeader.getContentLength(),
                             protocolHeader.getSessionId(), content);
    }
}
