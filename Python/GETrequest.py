import urllib2
from random import randint

numbers = ["052009880","0525223435","0525223445","0540000000","0541111111","0541234567","0542222222","0542345678","054330440","054330809","0543333333","054334005","054337809","054337889","05455","0546666666","0547777777","0548888888","05488888888"]

for i in numbers:
    lonRs = '34.89' + str(randint(71000, 89000))
    lonR = float(lonRs)
    lanRs = '32.44' + str(randint(49000, 59000))
    lanR = float(lanRs)
    urllib2.urlopen(
        "https://ipet-project-server.herokuapp.com/?command=PetSetLocation&number=" + i + "&lat=" + lanRs + "&lon=" + lonRs).read()
