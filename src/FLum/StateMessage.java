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
    private String voice_port = "";

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
        voice_port = splitted[5];
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

    public String getVoice_port() {
        return voice_port;
    }
}


