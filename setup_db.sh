#!/bin/sh
env PGCLIENTENCODING=UTF8 psql -U postgres -h 127.0.0.1 $(find . -name setup_db.sql | sed -e 's|^| -f |')
