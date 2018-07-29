https://www.python.org/ftp/python/2.7.15/python-2.7.15-macosx10.9.pkg

python --version
Python 2.7.15

pip --version
pip 9.0.3

pip install --no-cache-dir -r requirements.txt

python app.py

curl localhost:5000
ctrl-c

docker build -t burrsutter/flask_web_app .

docker run -it -p 5000:5000 --rm  burrsutter/flask_web_app

curl localhost:5000