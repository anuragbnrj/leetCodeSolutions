class Solution {
    public boolean canChange(String start, String target) {
        int len = start.length();

        int sptr = 0;
        int tptr = 0;

        for (; sptr < len && tptr < len; ) {
            if (start.charAt(sptr) == '_') {
                sptr += 1;
            } else if (target.charAt(tptr) == '_') {
                tptr += 1;
            } else {
                if (start.charAt(sptr) != target.charAt(tptr)) {
                    return false;
                } else {
                    if (start.charAt(sptr) == 'L') {
                        if (sptr < tptr) {
                            return false;
                        }
                    }

                    if (start.charAt(sptr) == 'R') {
                        if (sptr > tptr) {
                            return false;
                        }
                    }

                    sptr += 1;
                    tptr += 1;
                }
            }
        }

        while (sptr < len) {
            if (start.charAt(sptr) != '_') {
                return false;
            }

            sptr += 1;
        }

        while (tptr < len) {
            if (target.charAt(tptr) != '_') {
                return false;
            }

            tptr += 1;
        }

        return true;
    }
}