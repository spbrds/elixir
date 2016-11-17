# c "EnumModule.exs"

defmodule EnumModule do

	def all?([head | tail], fun), do: all?(tail, fun, fun.(head))
	def all?([head | tail]), do: all?([head | tail], fn(x) -> x != false and x != nil end, (head != false or head != nil))
	
	defp all?([],_,true), do: true
	defp all?(_, _, false), do: false
	defp all?(_, _, nil), do: false
	defp all?([head | tail], fun, true), do: all?(tail, fun, fun.(head))
	

	def each([], _fun), do: []
	def each([head | tail], fun), do: [fun.(head) | each(tail, fun)]

	def filter([], _fun), do: []
	def filter([head | tail], fun) do
		if(fun.(head)) do
			[head | filter(tail, fun)]
		else
			filter(tail, fun)
		end
	end 
	
	def take(enumerable, count) when count < 0 do takereverse(enumerable, (length enumerable) + count, (length enumerable), 0) end
	def take(enumerable, count), do: take(enumerable, count, 0)
	defp take(_, count,count), do: []
	defp take([],_,_), do: []
 	defp take([head | tail], count, index) when index < count do [head | take(tail, count,index+1)] end

	defp takereverse(_,_, endIndex, endIndex), do: []
	defp takereverse([head | tail], begin, endIndex, index) when index >= begin do [head | takereverse(tail, begin, endIndex, index+1)] end
	defp takereverse([_ | tail], begin, endIndex, index), do: takereverse(tail, begin, endIndex, index+1)


	def split([head | tail], count) when count >= 0 do auxsplit([head | tail], {[],[]}, 0,count) end
#	def split([head | tail] count < 0) do:

	def auxsplit([], result, _index, _count), do: result
	def auxsplit([head | tail], {[headfirst | tailfirst], [headsecond | tailsecond]}, index, count) when index <= count do
		auxsplit([tail], {[headfirst | head], [headsecond, tailsecond]}, index + 1, count)
	end
	def auxsplit([head | tail], {[headfirst | tailfirst], [headsecond | tailsecond]}, index, count) when index > count do
		auxsplit([tail], {[headfirst | tailfirst], [headsecond | head]}, index + 1, count)
	end
	
	def flatten([]), do: []
	def flatten([head | tail]), do: flattenlist([head | tail])

	defp flattenlist([]), do: []	
	defp flattenlist([head | tail]) do
		if(islist(head)) do
		 	flattenlist(head) ++ flattenlist(tail)
		else
			[head] ++ flattenlist(tail)
			
		end
	end

	defp islist([_head | _tail]), do: true
	defp islist(_), do: false
	
	def reverse([]), do: []
	def reverse([head|tail]), do: reverse(tail) ++ [head]
	
end

