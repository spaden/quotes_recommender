from flask import Flask, request, jsonify
import json

from sklearn.externals import joblib
from sklearn.feature_extraction.text import TfidfVectorizer

import re
reg = re.compile(r'[a-zA-Z]')

import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
from nltk.stem import PorterStemmer
import random

stemming = PorterStemmer()
stop_list = set(stopwords.words('english'))
savedModel = joblib.load('quotes_model.pkl')
vectorizer = TfidfVectorizer()
app = Flask(__name__)

trainedModelOutput = open('trainPred.json',)    
quotes_data = json.load(trainedModelOutput)

def remove_noise(quote_word):
    words = word_tokenize(quote_word)
    currentQuote = []
    for word in words:
        if word not in stop_list and word.isalpha() and word not in [",", ".", "!", " ", ";"] and reg.match(word):
                currentQuote.append(stemming.stem(word.lower()))
    
    return " ".join(currentQuote)


@app.route('/test')
def index():
    return "Hello World"
   

@app.route("/getSimilarQuote", methods=['POST'])
def postTest():
    data = request.json
    
    remove_noise(data['userInput'])
    Xt = vectorizer.fit_transform([data['userInput']])
    
    mod_Pt = [0 for i in range(0, 500)]

    for i in range(len(Xt.toarray()[0])):
        mod_Pt[i] = Xt.toarray()[0][i]
    pred_group =  savedModel.predict([mod_Pt])[0]
    pred_group_list = quotes_data[str(pred_group)]
    return {'res': random.choice(pred_group_list)}



if __name__ == "__main__":
    app.run(debug=True, host='127.0.0.1', port = '8002')

