import os
import cloudinary
from cloudinary.uploader import upload
import pymysql.cursors

# Cloudinary 계정 설정
cloudinary.config(
    cloud_name='ddmvbs5mz',
    api_key='163437389636211',
    api_secret='*************************'
)

# MySQL 연결 설정
connection = pymysql.connect(
    host='localhost',
    user='****',
    password='**********',
    db='fityou',
    charset='utf8mb4',
    cursorclass=pymysql.cursors.DictCursor
)

# 로컬 이미지 폴더 경로 설정
local_image_folder = 'c:\\Users\\402-16\\Desktop\\img'

# 로컬 폴더 내 모든 이미지 파일 업로드 및 MySQL에 저장
try:
    with connection.cursor() as cursor:
        for filename in os.listdir(local_image_folder):
            if filename.endswith(('.jpg', '.jpeg', '.png')):
                image_path = os.path.join(local_image_folder, filename)

                # 이미지 업로드
                upload_result = upload(image_path)

                # 업로드된 이미지 URL 및 파일 이름을 MySQL에 저장
                image_url = upload_result['secure_url']
                sql = "INSERT INTO images (file_name, image_url) VALUES (%s, %s)"
                cursor.execute(sql, (filename, image_url))
                connection.commit()

                print(f"Uploaded Image URL for {filename}: {image_url}")
finally:
    connection.close()
