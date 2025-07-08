'''
The Valid shortcuts of a string "abcd", are as follows:
abcd, abcd, a1cd, ab1d, abc1, 2cd, a2d, ab2, 1b1d, 1bc1,a1c1, 1b2, 2c1, 3d, a3, 4

You are given a string S and shortcut string  SC, 
Your task is to find out whether the string matches with the given shortcut or not.
if matched print true, else false.

Note:
String S contains only lowercase letters and String SC contains only 
lowercase letters and digits.

Input Format:
-------------
Two space separated Strings S and SC

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
internationalization i12iz4n

Sample Output-1:
----------------
true


Sample Input-2:
---------------
apple a2e

Sample Output-2:
----------------
false

'''
def backtrack(s1,start,st,index):
    if start == len(s1):
        if index > 0:
            st += str(index)
        
        arr.append(st)
        return
    backtrack(s1,start + 1 , st,index + 1)
    
    new_str = st
    if index > 0:
        new_str += str(index)
    new_str += s1[start]
    
    backtrack(s1,start + 1,new_str,0)
    

s = input().split(" ")
s1 = s[0]
s2 = s[1]
arr = []
backtrack(s1,0,"",0)
print(s2 in arr)

# def is_valid_shortcut(S, SC):
#     i = 0 
#     j = 0  

#     while i < len(S) and j < len(SC):
#         if SC[j].isdigit():
#             if SC[j] == '0':
#                 return False
#             num = 0
#             while j < len(SC) and SC[j].isdigit():
#                 num = num * 10 + int(SC[j])
#                 j += 1
#             i += num
#         else:
#             if i >= len(S) or S[i] != SC[j]:
#                 return False
#             i += 1
#             j += 1

#     return i == len(S) and j == len(SC)

# s = input().split()
# S = s[0]
# SC = s[1]

# print(is_valid_shortcut(S, SC))