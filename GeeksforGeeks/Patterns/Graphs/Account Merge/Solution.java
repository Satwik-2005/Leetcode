// class DisjointSet {
//     List<Integer> parent = new ArrayList<>();
//     List<Integer> rank = new ArrayList<>();
//     List<Integer> size = new ArrayList<>();

//     public DisjointSet(int n) {
//         for(int i=0;i<=n;i++) {
//             parent.add(i);
//             rank.add(0);
//             size.add(1);
//         }
//     }

//     public void unionByRank(int u, int v) {
//         int ultimateParentOfU = findParent(u);
//         int ultimateParentOfV = findParent(v);

//         if(ultimateParentOfU == ultimateParentOfV)
//             return;

//         if(rank.get(ultimateParentOfU) < rank.get(ultimateParentOfV))
//             parent.set(ultimateParentOfU, ultimateParentOfV);

//         else if(rank.get(ultimateParentOfU) > rank.get(ultimateParentOfV))
//             parent.set(ultimateParentOfV, ultimateParentOfU);

//         else {
//             parent.set(ultimateParentOfV, ultimateParentOfU);

//             int rankU = rank.get(ultimateParentOfU);

//             rank.set(ultimateParentOfU, rankU + 1);
//         }
//     }

//     public void unionBySize(int u, int v) {
//         int ultimateParentOfU = findParent(u);
//         int ultimateParentOfV = findParent(v);

//         if(ultimateParentOfU == ultimateParentOfV)
//             return;

//         if(size.get(ultimateParentOfU) < size.get(ultimateParentOfV)) {
//             parent.set(ultimateParentOfU, ultimateParentOfV);
//             size.set(ultimateParentOfV, size.get(ultimateParentOfU) + size.get(ultimateParentOfV));
//         }

//         else {
//             parent.set(ultimateParentOfV, ultimateParentOfU);
//             size.set(ultimateParentOfU, size.get(ultimateParentOfU) + size.get(ultimateParentOfV));
//         }
//     }

//     public int findParent(int node) {
//         if(node == parent.get(node))
//             return node;

//         int ultimateParent = findParent(parent.get(node));
//         parent.set(node, ultimateParent);

//         return parent.get(node);
//     }
// }

// class Solution {
//     public ArrayList<ArrayList<String>> accMerge(String[][] arr) {
//         // code here
//         int n = arr.length;
//         DisjointSet dsu = new DisjointSet(n);
        
//         Map<String, Integer> map = new HashMap<>();
        
//         for(int i=0;i<n;i++) {
//             for(int j=1;j<arr[i].length;i++) {
//                 String mail = arr[i][j];
                
//                 if(!map.containsKey(mail))
//                     map.put(mail, i);
                    
//                 else
//                     dsu.unionBySize(i, map.get(mail));
//             }
//         }
        
//         ArrayList<String>[] level = new ArrayList[n];
        
//         for(int i=0;i<n;i++)
//             level[i] = new ArrayList<>();
            
//         for(Map.Entry<String, Integer> mp : map.entrySet()) {
//             String mail = mp.getKey();
//             int node = mp.getValue();
            
//             int node = dsu.findParent(mp.getValue());
//             level[node].add(mail);
//         }
        
//         ArrayList<ArrayList<String>> ans = new ArrayList<>();
            
//         for(int i=0;i<n;i++) {
//             if(level[i].isEmpty())
//                 continue;
                
//             Collections.sort(level[i]);
//             List<String> temp = new ArrayList<>();
//             temp.add(arr[i][0]);
            
//             for(String it : level[i])
//                 temp.add(it);
                
//             ans.add(temp);
//         }
        
//         return ans;
//     }
// }

 class DisjointSet {

     List<Integer> parent = new ArrayList<>();
     List<Integer> rank = new ArrayList<>();
     List<Integer> size = new ArrayList<>();

     public DisjointSet(int n) {
         for(int i = 0; i <= n; i++) {
             parent.add(i);
             rank.add(0);
             size.add(1);
         }
     }

     public void unionByRank(int u, int v) {

         int ultimateParentOfU = findParent(u);
         int ultimateParentOfV = findParent(v);

         if(ultimateParentOfU == ultimateParentOfV)
             return;

         if(rank.get(ultimateParentOfU) < rank.get(ultimateParentOfV))
             parent.set(ultimateParentOfU, ultimateParentOfV);

         else if(rank.get(ultimateParentOfU) > rank.get(ultimateParentOfV))
             parent.set(ultimateParentOfV, ultimateParentOfU);

         else {
             parent.set(ultimateParentOfV, ultimateParentOfU);
             rank.set(
                 ultimateParentOfU,
                 rank.get(ultimateParentOfU) + 1
             );
         }
     }

     public void unionBySize(int u, int v) {

         int ultimateParentOfU = findParent(u);
         int ultimateParentOfV = findParent(v);

         if(ultimateParentOfU == ultimateParentOfV)
             return;

         if(size.get(ultimateParentOfU) < size.get(ultimateParentOfV)) {

             parent.set(ultimateParentOfU, ultimateParentOfV);

             size.set(
                 ultimateParentOfV,
                 size.get(ultimateParentOfU)
                 + size.get(ultimateParentOfV)
             );

         } else {

             parent.set(ultimateParentOfV, ultimateParentOfU);

             size.set(
                 ultimateParentOfU,
                 size.get(ultimateParentOfU)
                 + size.get(ultimateParentOfV)
             );
         }
     }

     public int findParent(int node) {

         if(node == parent.get(node))
             return node;

         int ultimateParent = findParent(parent.get(node));

         parent.set(node, ultimateParent);

         return ultimateParent;
     }
 }

 class Solution {

     public ArrayList<ArrayList<String>> accMerge(String[][] arr) {

         int n = arr.length;

         DisjointSet dsu = new DisjointSet(n);

         Map<String, Integer> map = new HashMap<>();

         // Step 1: Connect accounts having common emails
         for(int i = 0; i < n; i++) {

             for(int j = 1; j < arr[i].length; j++) {

                 String mail = arr[i][j];

                 if(!map.containsKey(mail)) {

                     map.put(mail, i);

                 } else {

                     dsu.unionBySize(i, map.get(mail));
                 }
             }
         }

         // Step 2: Store emails according to ultimate parent
         ArrayList<String>[] level = new ArrayList[n];

         for(int i = 0; i < n; i++)
             level[i] = new ArrayList<>();

         for(Map.Entry<String, Integer> entry : map.entrySet()) {

             String mail = entry.getKey();

             int node = dsu.findParent(entry.getValue());

             level[node].add(mail);
         }

         // Step 3: Construct answer
         ArrayList<ArrayList<String>> ans = new ArrayList<>();

         for(int i = 0; i < n; i++) {

             if(level[i].isEmpty())
                 continue;

             Collections.sort(level[i]);

             ArrayList<String> temp = new ArrayList<>();

             temp.add(arr[i][0]);

             for(String mail : level[i])
                 temp.add(mail);

             ans.add(temp);
         }

         return ans;
     }
 }
  