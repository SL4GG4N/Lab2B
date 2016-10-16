package PhoneContext;

/**
 * Created by Eddie on 2016-10-11.
 */
public class StateMessage {
    private String signal = "";
    private String sip_to = "";
    private String sip_from = "";
    private String ip_reciever = "";
    private String ip_caller = "";
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
        ip_reciever = splitted[3];
        ip_caller = splitted[4];
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

    public String getIp_reciever() {
        return ip_reciever;
    }

    public String getIp_caller() {
        return ip_caller;
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

    public void setIp_reciever(String ip_reciever) {
        this.ip_reciever = ip_reciever;
    }

    public void setIp_caller(String ip_caller) {
        this.ip_caller = ip_caller;
    }

    public void setVoice_port(int voice_port) {
        this.voice_port = voice_port;
    }
}


