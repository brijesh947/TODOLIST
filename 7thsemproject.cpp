#include<bits/stdc++.h>
using namespace std;
#define n 100
string pkt[n];
string pkt[0][82] = {
	"00", "00", "5e", "00", "01", "70", "3c", "a0", /* ..^..p<. */
	"67", "a6", "91", "7d", "08", "00", "45", "00", /* g..}..E. */
	"00", "44", "63", "bc", "00", "00", "80", "11", /* .Dc..... */
	"8c", "5d", "0a", "01", "30", "7f", "08", "08", /* .]..0... */
	"08", "08", "c9", "07", "00", "35", "00", "30", /* .....5.0 */
	"8b", "89", "8f", "c8", "01", "00", "00", "01", /* ........ */
	"00", "00", "00", "00", "00", "00", "06", "63", /* .......c */
	"6c", "69", "65", "6e", "74", "03", "77", "6e", /* lient.wn */
	"73", "07", "77", "69", "6e", "64", "6f", "77", /* s.window */
	"73", "03", "63", "6f", "6d", "00", "00", "01", /* s.com... */
	"00", "01"                                    /* .. */
};
int main()
{
	vector<string>v;
	int l=82/4;
	int r=82%4;
	string s="pkt1";
	
//	for(int i=0;i<4*l;i=i+4)
//	{
//		string s="";
//		s=pkt1[i]+pkt1[i+1]+pkt1[i+2]+pkt1[i+3];
//		v.push_back(s);
//	}
	
}
