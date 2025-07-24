package leetcode.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution71 {
    public String simplifyPath(String path) {
        String[] folders = path.split("/");
        List<String> folderList = new ArrayList<>(Arrays.asList(folders));
        for(int i = 0; i< folderList.size(); i++) {
            String folder = folderList.get(i);
            if("..".equals(folder)) {
                folderList.remove(i);
                i--;
                if(i >= 0) {
                    folderList.remove(i);
                    i--;
                }
            }else if(".".equals(folder) || folder.isEmpty()) {
                folderList.remove(i);
                i--;
            }
        }
        return "/" + String.join("/",folderList);
    }

    public static void main(String[] args) {
        Solution71 solution71 = new Solution71();
        String result = solution71.simplifyPath("/a/./b/../../c/");
        System.out.println(result);
    }
}
