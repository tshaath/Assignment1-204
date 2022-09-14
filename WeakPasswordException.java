public class WeakPasswordException extends Exception{
    public WeakPasswordException()
    {
        super("Password contains 6 to 9 characters which are otherwise valid");
    }
}
