#!/bin/bash
set -e

echo "🧪 Starting Tests with Docker Compose..."
docker compose up --build

echo "✅ Tests completed. Check reports in ./reports"

