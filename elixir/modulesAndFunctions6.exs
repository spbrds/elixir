defmodule Numbers do
	
	#def guess (actual, range) when is_number(range) do range end
	def guess(actual, range) do
		a..b = range
		varGuess = div(a+b,2)
		IO.puts("Trying #{varGuess}")
		auxGuess(actual,varGuess, range) 

	end
	
	def auxGuess(actual, actual, _), do: IO.puts("it is #{actual}")
	def auxGuess(actual, guess, _a..b) when actual > guess do guess(actual, guess+1..b) end 
	def auxGuess(actual, guess, a.._b) when actual < guess do guess(actual, a..guess-1) end
end	

