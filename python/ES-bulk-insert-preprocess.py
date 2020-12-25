import numpy as np
import pandas as pd
import os

base_dir = "../data"
excel_file = "sample_hotel.xlsx"
hotel = pd.read_excel(os.path.join(base_dir, excel_file), engine='openpyxl')

hotel = hotel.replace(np.nan, '', regex=True) # remove set nan

f = open("../data/ES-bulk-insert-hotel.json", 'w', encoding="utf-8")

for i in hotel.index :
    number = '"number":'+str(i+1)
    nameEdit = '"name":'+'"'+hotel.loc[i, 'name']+'"'
    areaEdit = '"area":'+'"'+hotel.loc[i, 'area']+'"'
    typeEdit = '"type":'+'"'+hotel.loc[i, 'type']+'"'
    addressEdit = '"address":'+'"'+hotel.loc[i, 'address']+'"'
    pin = hotel.loc[i, 'pin'][1:len(hotel.loc[i, 'pin'])-1]
    pin = pin.replace("'","\"");
    f.write('{\"index\":{\"_index\":\"hotel\"}}\n')
    f.write("{"+nameEdit+","+pin+","+areaEdit+","+typeEdit+","+addressEdit+","+number+"}\n")

f.close()
