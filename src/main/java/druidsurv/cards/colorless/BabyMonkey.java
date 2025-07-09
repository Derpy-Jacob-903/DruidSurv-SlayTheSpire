package druidsurv.cards.colorless;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class BabyMonkey extends AbstractEasyCard {
    public final static String ID = makeID("BabyMonkey");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public BabyMonkey() {
        super(ID, 0, CardType.STATUS, CardRarity.SPECIAL, CardTarget.NONE, CardColor.COLORLESS, "BabyMonkey_CardArt");
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
    }

    /*public void triggerOnOtherCardPlayed(AbstractCard c) {
        int monkeys = 0;
        for (int i = 0; i < AbstractDungeon.player.hand.size(); i++) {
            if (AbstractDungeon.player.hand.group.get(i).hasTag(druidsurv.cards.cardvars.CardTags.MONKEY))
            {
                monkeys++;
            }
            if (monkeys > 5)
            {
                addToBot(new DiscardSpecificCardAction(this, AbstractDungeon.player.hand));
                break;
            }
        }
    }*/

    @Override
    public void upp() {
    }
}