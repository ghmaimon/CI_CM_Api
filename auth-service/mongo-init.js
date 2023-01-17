db.createUser(
    {
        user: "ci-cm-auth-service",
        pwd: "ci-cm-auth-service",
        roles: [
            {
                role: "readWrite",
                db: "messaging"
            }
        ]
    }
);