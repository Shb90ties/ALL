import threading
#import time , time.sleep(milisecons) , for making current thread sleep

class messagingThreads(threading.Thread):
    def run(self):
        for i in range(10):
            print(threading.currentThread().getName())


x = messagingThreads(name='thread 1')
y = messagingThreads(name='thread 2')

x.start()
y.start()