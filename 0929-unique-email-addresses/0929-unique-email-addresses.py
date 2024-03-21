class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        unique_emails = set()
        for email in emails:
            split = email.split("@")
            first_part = split[0]
            domain = split[1]
            period_removed = "".join(first_part.split("."))
            plus_removed = period_removed.split("+")[0]
            unique_emails.add(plus_removed + "@" + domain)
        return len(unique_emails)
        