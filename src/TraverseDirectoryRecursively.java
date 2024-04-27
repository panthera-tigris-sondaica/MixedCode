import java.io.File;

public class TraverseDirectoryRecursively {
    private static final String SEP = "\t";
    public static void main(String[] args) {
        String folder = "D:\\test";
        System.out.println("Directory Structure of: "+folder);
        printFolderStructure(new File(folder),"");
    }

    private static void printFolderStructure(File file, String sep) {
        System.out.println(sep+file.getName());
        if(file.isDirectory()){
            File[] childs = file.listFiles();
            if(childs!=null) for(File child: childs){
                printFolderStructure(child,sep+SEP);
            }
        }
    }
}
