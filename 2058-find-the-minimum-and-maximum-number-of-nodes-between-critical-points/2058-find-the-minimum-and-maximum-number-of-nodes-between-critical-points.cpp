class Solution {
public:
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        int Min = 100000, i = 1;
        int c[2] = {0, 0};

        auto prev = head, curr = head->next, nxt = head->next->next;

        auto isCrit = [&]() {
            auto x = prev->val, y = curr->val, z = nxt->val;
            return (x < y && y > z) || (x > y && y < z);
        };

        while (nxt) {
            if (isCrit()) {
                if (c[0]) Min = min(Min, i - c[c[1] > 0]);
                c[c[0] > 0] = i;
            }

            prev = curr; curr = nxt;
            nxt = nxt->next; i++;
        }

        if (c[1]) return {Min, c[1] - c[0]};

        return {-1, -1};
    }
};