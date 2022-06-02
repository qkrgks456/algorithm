package my;

public class Test {
    public static void main(String[] args) {
        String topic = "REV_msa_mylgdb.imcsuser.pt_la_album_img";
        StringBuffer stringBuffer = new StringBuffer(topic);
        System.out.println(stringBuffer.replace(0, 8, "").insert(0, "db2db."));

    }
}
