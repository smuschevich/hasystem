;
; BIND data file for db.hasystem.com
;
$TTL	604800
@	IN	SOA	hasystem.com. root.hasystem.com. (
			      2		; Serial
			 604800		; Refresh
			  86400		; Retry
			2419200		; Expire
			 604800 )	; Negative Cache TTL
;
@	IN	NS	ns.hasystem.com.
ns	IN	A	10.7.0.3
@	IN	A	10.7.0.3
    IN	A	10.7.0.4
@	IN	AAAA	::1
www IN  A   10.7.0.3
    IN  A   10.7.0.4
