package jp.ac.aiit.jointry.services.broker.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.ac.aiit.jointry.services.broker.core.DInfo;
import jp.ac.aiit.jointry.services.broker.core.DialogBase;

public class JointryBrokerDialog extends DialogBase {

    private static boolean installed = false;
    private static final Calendar cal = Calendar.getInstance();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
    private static final String crlf = System.getProperty("line.separator");
    private static FileWriter filewriter;
    private static final String separator = ",";

    public static void install() {
        if (!installed) {
            DialogBase.addDialog(JointryCommon.D_MAIN, JointryBrokerDialog.class);
            DialogBase.addDialog(JointryCommon.D_SPRITE, JointryBrokerDialog.class);
            DialogBase.addDialog(JointryCommon.D_BLOCK, JointryBrokerDialog.class);

            File file = new File(System.getProperty("user.dir") + "\\log" + sdf.format(cal.getTime()));
            try {
                filewriter = new FileWriter(file, true);
            } catch (IOException ex) {
                Logger.getLogger(JointryBrokerDialog.class.getName()).log(Level.SEVERE, null, ex);
            }

            installed = true;
        }
    }

    @Override
    public void onAnswer(final DInfo dinfo) {
        outputLog(dinfo);
    }

    @Override
    public void onQuery(final DInfo dinfo) {
        outputLog(dinfo);
    }

    @Override
    public void onNotify(final DInfo dinfo) {
        outputLog(dinfo);
    }

    private void outputLog(final DInfo dinfo) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(sdf.format(cal.getTime()));
        buffer.append(separator);
        buffer.append(dinfo.get(JointryCommon.USER_ID));
        buffer.append(separator);
        buffer.append(dinfo.getInt(JointryCommon.K_METHOD));
        buffer.append(crlf);

        try {
            filewriter.write(buffer.toString());
            filewriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(JointryBrokerDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
