public class NoSpecialCharacterException extends Exception{
    public NoSpecialCharacterException()
    {
        super("Password doesn’t contain a special character");
    }
}
