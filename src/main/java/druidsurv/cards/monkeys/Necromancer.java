package druidsurv.cards.monkeys;

import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.MultiCardPreview;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.colorless.UndeadBloon;
import druidsurv.powers.monkeys.NecroPower;

import static druidsurv.ModFile.makeID;

public class Necromancer extends AbstractEasyCard {
    public final static String ID = makeID("Necromancer");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public Necromancer() {
        super(ID, 2, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF, "Necromancer_CardArt");
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);

        MultiCardPreview.add(this, new UndeadBloon()); // Display both Smite and Safety when you hover this card.
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new NecroPower(p, magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp() {

    }
}