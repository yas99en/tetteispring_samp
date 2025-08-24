#!/bin/sh
env PGCLIENTENCODING=UTF8 psql -U postgres $(find . -name setup_db.sql | sed -e 's|^| -f |')
