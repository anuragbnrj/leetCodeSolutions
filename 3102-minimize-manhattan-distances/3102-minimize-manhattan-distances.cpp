class Solution {
public:
    int minimumDistance(vector<vector<int>>& points) {
        int n = points.size();
        int minsum, maxsum, mindiff, maxdiff;
        
        minsum = maxsum = points[0][0] + points[0][1];   
        mindiff = maxdiff = points[0][0] - points[0][1];
        
        vector<int> sum(n, 0), diff(n, 0);
        int minsumi, maxsumi, mindiffi, maxdiffi;
        minsumi = maxsumi = mindiffi = maxdiffi = 0;
        int temp;
        
        for (int i = 1; i < n; i++) {
            sum[i] = points[i][0] + points[i][1];
            diff[i] = points[i][0] - points[i][1];
            if (sum[i] < minsum) {
                minsum = sum[i];
                minsumi = i;
            }
                
            else if (sum[i] > maxsum) {
                maxsum = sum[i];
                maxsumi = i;
            }
                
            if (diff[i] < mindiff) {
                mindiff = diff[i];
                mindiffi = i;
            }
                
            else if (diff[i] > maxdiff){
                maxdiff = diff[i];
                maxdiffi = i;
            }
                
        }
        int res = max(maxsum - minsum, maxdiff - mindiff);
        
        minsum = INT_MAX;
        maxsum = INT_MIN;
        mindiff = INT_MAX;
        maxdiff = INT_MIN;
        for (int i = 0; i < n; i++) {
            if (i == minsumi) {
                continue;
            }
            
            if (sum[i] < minsum) {
                minsum = sum[i];
            } else if (sum[i] > maxsum) {
                maxsum = sum[i];
            }
                
            if (diff[i] < mindiff) {
                mindiff = diff[i];
            } else if (diff[i] > maxdiff){
                maxdiff = diff[i];
            }
            
        }
        temp = max(maxsum - minsum, maxdiff - mindiff);
        res = min(res, temp);
        
        minsum = INT_MAX;
        maxsum = INT_MIN;
        mindiff = INT_MAX;
        maxdiff = INT_MIN;
        for (int i = 0; i < n; i++) {
            if (i == maxsumi) {
                continue;
            }
            
            if (sum[i] < minsum) {
                minsum = sum[i];
            } else if (sum[i] > maxsum) {
                maxsum = sum[i];
            }
                
            if (diff[i] < mindiff) {
                mindiff = diff[i];
            } else if (diff[i] > maxdiff){
                maxdiff = diff[i];
            }
            
        }
        temp = max(maxsum - minsum, maxdiff - mindiff);
        res = min(res, temp);
        
        minsum = INT_MAX;
        maxsum = INT_MIN;
        mindiff = INT_MAX;
        maxdiff = INT_MIN;
        for (int i = 0; i < n; i++) {
            if (i == mindiffi) {
                continue;
            }
            
            if (sum[i] < minsum) {
                minsum = sum[i];
            } else if (sum[i] > maxsum) {
                maxsum = sum[i];
            }
                
            if (diff[i] < mindiff) {
                mindiff = diff[i];
            } else if (diff[i] > maxdiff){
                maxdiff = diff[i];
            }
            
        }
        temp = max(maxsum - minsum, maxdiff - mindiff);
        res = min(res, temp);
        
        minsum = INT_MAX;
        maxsum = INT_MIN;
        mindiff = INT_MAX;
        maxdiff = INT_MIN;
        for (int i = 0; i < n; i++) {
            if (i == maxdiffi) {
                continue;
            }
            
            if (sum[i] < minsum) {
                minsum = sum[i];
            } else if (sum[i] > maxsum) {
                maxsum = sum[i];
            }
                
            if (diff[i] < mindiff) {
                mindiff = diff[i];
            } else if (diff[i] > maxdiff){
                maxdiff = diff[i];
            }
            
        }
        temp = max(maxsum - minsum, maxdiff - mindiff);
        res = min(res, temp);
        
        
        
        return res;
        
    }
};