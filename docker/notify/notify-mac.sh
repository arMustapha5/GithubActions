#!/bin/bash

RESULT=$1
STATUS="❌ Tests Failed"
if [ "$RESULT" -eq 0 ]; then
  STATUS="✅ Tests Passed"
fi


curl "smtp://mailhog:1025" \
     --mail-from "$MAIL_USERNAME" \
     --mail-rcpt "$NOTIFICATION_EMAIL" \
     --upload-file - <<EOF
From: CI Bot <$MAIL_USERNAME>
To: <$NOTIFICATION_EMAIL>
Subject: Test Results

$STATUS
Repo: $GITHUB_REPOSITORY
Commit: $GITHUB_SHA
EOF




curl -X POST -H "Content-type: application/json" \
--data "{\"text\":\"$STATUS\nRepo: $GITHUB_REPOSITORY\nCommit: $GITHUB_SHA\nTrigger: $GITHUB_EVENT_NAME\nCheck logs: $GITHUB_SERVER_URL/$GITHUB_REPOSITORY/actions/runs/$GITHUB_RUN_ID\"}" \
"$SLACK_WEBHOOK_URL"

