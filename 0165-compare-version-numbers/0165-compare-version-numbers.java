class Solution {
    public int compareVersion(String version1, String version2) {
        String[] splitVersion1 = version1.split("\\.");
        String[] splitVersion2 = version2.split("\\.");

        int i = 0, j = 0;
        for ( ; i < splitVersion1.length && j < splitVersion2.length; i++, j++) {
            int v1 = Integer.parseInt(splitVersion1[i]);
            int v2 = Integer.parseInt(splitVersion2[j]);

            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }

        while (i < splitVersion1.length) {
            int v1 = Integer.parseInt(splitVersion1[i]);
            int v2 = 0;

            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }

            i++; 
        }

        
        while (j < splitVersion2.length) {
            int v1 = 0;
            int v2 = Integer.parseInt(splitVersion2[j]);

            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }

            j++;
        }

        return 0;        
    }
}