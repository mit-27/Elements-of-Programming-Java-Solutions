import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Problem_8_4 {
    // NORMALIZE PATHNAMES

    // A file or directory can be specified via a string called the pathname. This string may
    //specify an absolute path, starting from the root, e.g., /usr/bin/gcc, or a path relative
    //to the current working directory, e.g., scripts/awkscripts.
    //The same directory may be specified by multiple directory paths. For exam¬
    //ple, /usr/lib/../bin/gcc and scripts//./,./scripts/awkscripts/././ specify
    //equivalent absolute and relative pathnames.

    //Write a program which takes a pathname, and returns the shortest equivalent path¬
    //name. Assume individual directories and files have names that use only alphanu¬
    //meric characters. Subdirectory names may be combined using forward slashes (/),
    //the current directory ( .), and parent directory (. .).

    public static void main(String[] args) {
        String s = "scripts/./../scripts/awkscripts/./.";
        System.out.println(normalizePathName(s));
    }


    // Time 0(n) where n= no of directory specified in path
    public static String normalizePathName(String inputS)
    {
        if(inputS.length()==0)
        {
            return inputS;
        }

        String[] dirNames = inputS.split("/");

        Deque<String> stack = new LinkedList<>();
        for(String dir : dirNames)
        {
            // if dir is . then do not push to stack and if .. then pop from stack
            if(dir.equals(".."))
            {
                stack.removeFirst();
            }

            if(dir.length()!=0 && !dir.equals(".") && !dir.equals(".."))
            {
                stack.addFirst(dir);
            }
        }

        // now we build final answer from remain part in stack
        // as we encountered . and .. remaining in stack would represent shortest path
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty())
        {
            ans.insert(0,stack.removeFirst());
            ans.insert(0,"/");
        }

        if(inputS.charAt(0)!='/')
        {
            ans.replace(0,1,"");
        }

        return ans.toString();

    }
}
