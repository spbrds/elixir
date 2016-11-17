IO.puts "module init"

functionFizzBuzz = fn 
(0,0,_) -> "FizzBuzz"
(0,_,_) -> "Fizz"
(_,0,_) -> "Buzz"
(_,_,c) -> c
end

IO.puts functionFizzBuzz.(0,0,1)
IO.puts functionFizzBuzz.(0,"coiso","coisa")
IO.puts functionFizzBuzz.(2,0,1)
IO.puts functionFizzBuzz.(2,3,"cenas")


########pag 41 Function scopes
IO.puts("###### page 41 ######");

remFizzBuzz = fn (n) -> functionFizzBuzz.(rem(n,3), rem(n,5), n)
end;

#asserting result for invocation with 10
"Buzz" = remFizzBuzz.(10)

IO.puts remFizzBuzz.(10)
IO.puts remFizzBuzz.(11)
IO.puts remFizzBuzz.(12)
IO.puts remFizzBuzz.(13)
IO.puts remFizzBuzz.(14)
IO.puts remFizzBuzz.(15)
IO.puts remFizzBuzz.(16)

 
