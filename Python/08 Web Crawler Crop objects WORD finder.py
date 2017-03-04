import requests
from bs4 import BeautifulSoup

CropURL = 'https://www.crummy.com/software/BeautifulSoup/bs4/doc/'
SourceCode = requests.get(CropURL)
SourceInText = SourceCode.text
Soup = BeautifulSoup(SourceInText)
# works on links, for something else change 'a'(the type) and 'href'(The part of the html object)
i = 1
arr = []
for link in Soup.findAll('a',{'class':'reference internal'}):
    href = link.get('href')
    arr.append(href)

print('link number 5 that was found ',arr[5])



