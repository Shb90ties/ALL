import random
"""Import libaries File->Settings->Project->Project Interpreter->'+'->Search->V on install package in directory"""
import urllib
import request

def downliadImage(url):
    name = random.randrange(1,1000)
    fileName = str(name) + '.jpg'
    urllib.urlretrieve(url,fileName)


downliadImage("http://keenthemes.com/preview/metronic/theme/assets/global/plugins/jcrop/demos/demo_files/image1.jpg")

url_CSV_file = "http://chart.finance.yahoo.com/table.csv?s=KNM.L&a=8&b=16&c=2016&d=9&e=16&f=2016&g=d&ignore=.csv"

def downloadCSV_url(CSV_url):
    response = urllib.urlopen(CSV_url)
    csv = str(response.read())
    lines = csv.split("\\n")
    for l in lines:
        print (l)
