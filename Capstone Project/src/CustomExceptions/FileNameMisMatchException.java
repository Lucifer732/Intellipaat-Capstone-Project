package CustomExceptions;

@SuppressWarnings("serial")
public class FileNameMisMatchException extends Exception
{
	public FileNameMisMatchException(String text)
	{
		super(text);
	}
}
