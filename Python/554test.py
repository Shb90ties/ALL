import requests

to = [0, 0, 0, 0, 0, 0, 0, 0]
ins = [55,22,55,77,88,99,66,22,333,4,555,448,55,22,111,254,23,6658,54,215]

def list_handler(var_list, var):
    tmp_list = [0, 0, 0, 0, 0, 0, 0, 0]
    i = 1
    while i < 8:
        tmp_list[i - 1] = var_list[i]
        i += 1
    tmp_list[7] = var
    return tmp_list

for i in range(len(ins)):
    to = list_handler(to, ins[i])
    print to

path = "http://ipet-project-server.herokuapp.com"
parmBPM = {
            'command': 'putBPM',
            'putNum': '0547777777',
            'bpm': '67'
            }
reqst = requests.get(path,params=parmBPM)
if (reqst.content == 'inserted'):
    print 'updated BPM to DB of last 2 minutes, sent : '
else:
    print 'cant connect to the server, cant update the BPM'