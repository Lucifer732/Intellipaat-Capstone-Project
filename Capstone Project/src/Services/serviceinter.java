package Services;

import java.util.*;
import java.io.*;

import CustomExceptions.*;

public interface serviceinter
{
	void filewrite(String str) throws FileNotFoundException, IOException, UnbalancedParanthesisException, FileNameMisMatchException;
	void fileread(File f1, String str, HashSet<String> hset) throws IOException, UnbalancedParanthesisException, FileNameMisMatchException, KeywordsException;
}
