package inbusiness.space.webapp.service;

//import com.meandmyworld.admin.service.NaturalBuilderService;
//import com.meandmyworld.admin.service.website.MailInfo;
//import com.meandmyworld.admin.service.website.NamedContent;
import com.sun.mail.pop3.POP3SSLStore;
import inbusiness.space.webapp.dto.MailInfo;
import inbusiness.space.webapp.dto.NamedContent;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by wilfried on 01/11/15.
 */
public class PopReceiverUtil {

    private String host;
    private String port;
    private String user;
    private String password;

//    @Autowired
//    private NaturalBuilderService naturalBuilderService;

    private static final Logger log = LoggerFactory.getLogger(PopReceiverUtil.class);

    public List<MailInfo> receive() throws Exception {

        // TODO: externalize ....
        // mail server connection parameters
        //String host = "SSL0.OVH.NET";
        //String user = "no-reply@inbusiness.space";
        //String password = "new_user!";

        String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties pop3Props = new Properties();
        pop3Props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
        pop3Props.setProperty("mail.pop3.socketFactory.fallback", "false");
        pop3Props.setProperty("mail.pop3.port",  port);
        pop3Props.setProperty("mail.pop3.socketFactory.port", port);

        URLName url = new URLName("pop3", host, Integer.parseInt(port), "",
            user, password);

        Session session = Session.getInstance(pop3Props, null);
        Store store = new POP3SSLStore(session, url);
        store.connect();

        Folder inbox = store.getFolder("Inbox");
        inbox.open(Folder.READ_WRITE);

        // get the list of inbox messages
        Message[] messages = inbox.getMessages();

        if (messages.length == 0) log.info("No messages found.");

        List<MailInfo> mails = new ArrayList<>();

        for (int i = 0; i < messages.length; i++) {
            MailInfo mail = new MailInfo();
            writePart(messages[i], mail);

            mails.add(mail);

            // TO REACTIVATE ...
            messages[i].setFlag(Flags.Flag.DELETED, true);
        }

        inbox.close(true);
        store.close();

        return mails;
    }

    /*
   * This method checks for content-type
   * based on which, it processes and
   * fetches the content of the message
   */
    public static void writePart(Part p, MailInfo mailInfo) throws Exception {
        if (p instanceof Message)
            //Call methos writeEnvelope
            writeEnvelope((Message) p, mailInfo);

        log.info("----------------------------");
        log.info("CONTENT-TYPE: " + p.getContentType());

        //check if the content is plain text
        if (p.isMimeType("text/plain")) {
            log.info("This is plain text");
            log.info("---------------------------");
            log.info((String) p.getContent());

            mailInfo.setBody(p.getContent().toString());
        }
        //check if the content has attachment
        else if (p.isMimeType("multipart/*")) {
            log.info("This is a Multipart");
            log.info("---------------------------");
            Multipart mp = (Multipart) p.getContent();
            int count = mp.getCount();
            for (int i = 0; i < count; i++)
                writePart(mp.getBodyPart(i), mailInfo);
        }
        //check if the content is a nested message
        else if (p.isMimeType("message/rfc822")) {
            log.info("This is a Nested Message");
            log.info("---------------------------");
            writePart((Part) p.getContent(), mailInfo);
        }
        //check if the content is an inline image
        else if (p.isMimeType("image/jpeg")) {
            log.info("--------> image/jpeg");
            Object o = p.getContent();
            InputStream x = (InputStream) o;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            IOUtils.copy(x, bos);
            NamedContent namedContent = new NamedContent();
            namedContent.setName(p.getFileName());
            namedContent.setType(p.getContentType());
            namedContent.setContent(bos.toByteArray());
            mailInfo.getAttachments().add(namedContent);
        }
        else if (p.isMimeType("image/png")) {
            log.info("--------> image/png");
            Object o = p.getContent();
            InputStream x = (InputStream) o;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            IOUtils.copy(x, bos);
            NamedContent namedContent = new NamedContent();
            namedContent.setName(p.getFileName());
            namedContent.setType(p.getContentType());
            namedContent.setContent(bos.toByteArray());
            mailInfo.getAttachments().add(namedContent);
        }
        else if (p.getContentType().contains("image/")) {
            log.info("content type" + p.getContentType());
            File f = new File("image" + new Date().getTime() + ".jpg");
            DataOutputStream output = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(f)));
            com.sun.mail.util.BASE64DecoderStream test =
                (com.sun.mail.util.BASE64DecoderStream) p
                    .getContent();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = test.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        }
        else {
            Object o = p.getContent();
            if (o instanceof String) {
                log.info("This is a string");
                log.info("---------------------------");
                log.info((String) o);
            }
            else if (o instanceof InputStream) {
                log.info("This is just an input stream");
                log.info("---------------------------");
                InputStream is = (InputStream) o;
                is = (InputStream) o;
                int c;
                while ((c = is.read()) != -1)
                    System.out.write(c);
            }
            else {
                log.info("This is an unknown type");
                log.info("---------------------------");
                log.info(o.toString());
            }
        }

    }
    /*
    * This method would print FROM,TO and SUBJECT of the message
    */
    public static void writeEnvelope(Message m, MailInfo mail) throws Exception {
        log.info("This is the message envelope");
        log.info("---------------------------");
        Address[] a;

        // FROM
        if ((a = m.getFrom()) != null) {
            for (int j = 0; j < a.length; j++) {
                log.info("FROM: " + a[j].toString());
                InternetAddress adress = (InternetAddress)  a[j];
                mail.setFrom(adress.getAddress());
            }
        }

        // TO
        if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
            for (int j = 0; j < a.length; j++)  {
                log.info("TO: " + a[j].toString());
                mail.setTo(a[j].toString());
            }
        }

        // SUBJECT
        if (m.getSubject() != null)  {
            log.info("SUBJECT: " + m.getSubject());
            mail.setSubject(m.getSubject());
        }


    }




    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
