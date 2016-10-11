package FLum;

/**
 * Created by Eddie on 2016-10-11.
 */
public class StateMessage {
    private String signal = "";
    private String sip_to = "";
    private String sip_from = "";
    private String ip_to = "";
    private String ip_from = "";
    private int voice_port = 0;

    public StateMessage(String msg) {
        split(msg);
        System.out.println("SPLITTED: " + signal);
    }

    private void split(String msg){
        String[] splitted = msg.split(" ");

        if (splitted.length < 6){
            signal = splitted[0];
            return;
        }

        signal = splitted[0];
        sip_to = splitted[1];
        sip_from = splitted[2];
        ip_to = splitted[3];
        ip_from = splitted[4];
        voice_port = Integer.parseInt(splitted[5]);
    }

    public String getSignal() {
        return signal;
    }

    public String getSip_to() {
        return sip_to;
    }

    public String getSip_from() {
        return sip_from;
    }

    public String getIp_to() {
        return ip_to;
    }

    public String getIp_from() {
        return ip_from;
    }

    public int getVoice_port() {
        return voice_port;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }

    public void setSip_to(String sip_to) {
        this.sip_to = sip_to;
    }

    public void setSip_from(String sip_from) {
        this.sip_from = sip_from;
    }

    public void setIp_to(String ip_to) {
        this.ip_to = ip_to;
    }

    public void setIp_from(String ip_from) {
        this.ip_from = ip_from;
    }

    public void setVoice_port(int voice_port) {
        this.voice_port = voice_port;
    }
}


