class Solution {
public:
    int calPoints(vector<string>& operations) {
        stack<int> st;

        for (string s : operations) {

            if (s == "C") {
                st.pop();

            } else if (s == "D") {
                st.push(2 * st.top());

            } else if (s == "+") {
                int val1 = st.top();
                st.pop();

                int val2 = st.top();

                st.push(val1);
                st.push(val1 + val2);

            } else {
                st.push(stoi(s));
            }
        }

        int sum = 0;

        while (!st.empty()) {
            sum += st.top();
            st.pop();
        }

        return sum;
    }
};