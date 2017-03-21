fun f x y =
	let
		val a = x+1
		fun g 0 = 0
		|   g n =
			let
				val a = x+y
				fun h 0 = 0
				|   h k = a+n+g(n-1)
			in
				h (n-1)
			end
	in
		if (x=0) then g y
		else a + g(f (x-1) y )
	end;
