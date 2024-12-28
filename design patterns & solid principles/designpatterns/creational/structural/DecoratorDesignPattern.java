package designpatterns.creational.structural;
interface Message{
    String getContent();
}
class TextMessage implements Message{
    private String msg;
    public  TextMessage(String msg){
        this.msg=msg;
    }
    @Override
    public String getContent() {
        return msg;
    }
}
class HtmlEncodedMessage implements  Message{
    private Message message;
    public HtmlEncodedMessage(Message msg){
        this.message=msg;
    }
    @Override
    public String getContent() {


        return message.getContent()+" with html encoded";
    }
}
class Base64Message implements  Message{
    private Message message;
    public Base64Message(Message msg){
        this.message=msg;
    }
    @Override
    public String getContent() {


        return message.getContent()+" with base64 encoded";
    }
}
public class DecoratorDesignPattern {
    public static void main(String[] args) {
Message m=new TextMessage("This is the text message");
        System.out.println(m.getContent());
        Message decorator=new HtmlEncodedMessage(m);
        System.out.println(decorator.getContent());
        decorator=new Base64Message(decorator);
        System.out.println(decorator.getContent() );

    }
}
