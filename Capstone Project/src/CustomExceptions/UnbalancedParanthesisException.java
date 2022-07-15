package CustomExceptions;

@SuppressWarnings("serial")
public class UnbalancedParanthesisException extends Exception
{
	public UnbalancedParanthesisException(String text)
	{
		super(text);
	}
}
