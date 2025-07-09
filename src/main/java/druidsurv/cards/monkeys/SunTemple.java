package druidsurv.cards.monkeys;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import java.util.Iterator;

import static druidsurv.ModFile.makeID;
import static druidsurv.cards.cardvars.CardTags.MONKEY;

public class SunTemple extends AbstractEasyCard {
    public final static String ID = makeID("SunTemple");
    private int round;
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public SunTemple() {
        super(ID, 6, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY, "SunTemple_CardArt");
        baseDamage = 30;
        baseMagicNumber = magicNumber = 5;
        //baseSecondMagic = secondMagic = cost*2;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);

        this.setCardBack(cardSubType.MONKEY);
    }

    public void atTurnStartPostDraw() {
        //round++;
        //secondMagic = (4-costForTurn)*2;
        //cost = 6 - round/3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        // Use an iterator to safely remove elements while iterating
        Iterator<AbstractCard> iterator = AbstractDungeon.player.hand.group.iterator();

        while (iterator.hasNext()) {
            AbstractCard c = iterator.next();
            if (c.hasTag(MONKEY)) {
                iterator.remove(); // Safely remove the card
                damage += 5;
            }
        }
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
    }


    @Override
    public void upp() {
        upgradeDamage(9);
    }
}