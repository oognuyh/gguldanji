INSERT INTO notices(notice_no, title, content, author_id, created_by, updated_at, updated_by) VALUES (100001, 'test title', 'test content', '4f167799-de8d-4163-a74c-4647e0185a35', '4f167799-de8d-4163-a74c-4647e0185a35', CURRENT_TIMESTAMP, '4f167799-de8d-4163-a74c-4647e0185a35');
INSERT INTO comments(talk_no, user_id, parent, child, comment, createdAt) values(1, 'tester', '1', null, 'hi', sysdate);