package cn.itlemon.grpc.serialization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jiangpingping
 * Created on 2020-08-24
 */
public class MsgPackDemo {

    private static final Logger logger = LoggerFactory.getLogger(MsgPackDemo.class);

    public static void main(String[] args) throws IOException {

        List<String> src = new ArrayList<>();
        src.add("msgpack");
        src.add("kumofs");
        src.add("viver");
        MessagePack msgpack = new MessagePack();
        byte[] raw = msgpack.write(src);
        List<String> dst1 =
                msgpack.read(raw, Templates.tList(Templates.TString));
        logger.info("result:{}", dst1);
    }
}
