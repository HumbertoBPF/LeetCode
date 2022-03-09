import java.util.Stack;

public class SolutionLeetCode71 {

	public static void main(String[] args) {
		String path = "/home//foo/";
		System.out.println(simplifyPath(path));
	}
	
	public static String simplifyPath(String path) {
		// Stack to store all the listed directories
        Stack<String> directoriesStack = new Stack<>(); 
        // Split the provided path to obtain all the directories
        String[] directories = path.split("/");
        
        for (String directory : directories) {
        	// If '..' is found, we come back one directory in the stack
        	if (directory.equals("..")) {
        		if (!directoriesStack.isEmpty()) {
            		directoriesStack.pop();
        		}
        	// If the String is neither '..' nor '.' nor '', we add it to the stack
        	}else if (!directory.equals(".") && !directory.isEmpty()){
        		directoriesStack.add(directory);
        	}
        }
        
        String canonicalPath = "";
        // From the stack, we build the canonical path
        for (String directory : directoriesStack) {
        	canonicalPath+=("/"+directory);
        }
        // If the canonical path is empty, we return a single bar
        if (canonicalPath.isEmpty()) {
        	return "/";
        }
        
        return canonicalPath;
    }
	
}
